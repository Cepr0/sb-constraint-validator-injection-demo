## Demo of the custom ConstraintValidator as a Spring Bean

Spring Boot allows injecting Spring beans to a ConstraintValidator, for example:

```java
@Slf4j
public class CaseValidator implements ConstraintValidator<CheckCase, String> {

    private final Predicate<String> uppercasePredicate;
    private final Predicate<String> lowercasePredicate;

    private CheckCase.CaseMode caseMode;

    @Autowired // not necessary annotation
    public CaseValidator(Predicate<String> uppercasePredicate, Predicate<String> lowercasePredicate) {
        this.uppercasePredicate = uppercasePredicate;
        this.lowercasePredicate = lowercasePredicate;
    }

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (caseMode == CheckCase.CaseMode.UPPER) {
            log.info("[i] Checking uppercase for value: {}", value);
            return uppercasePredicate.test(value);
        } else {
            log.info("[i] Checking lowercase for value: {}", value);
            return lowercasePredicate.test(value);
        }
    }
}
```