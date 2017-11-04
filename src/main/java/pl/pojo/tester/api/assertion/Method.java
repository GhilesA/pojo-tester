package pl.pojo.tester.api.assertion;


import pl.pojo.tester.internal.tester.AbstractTester;
import pl.pojo.tester.internal.tester.ConstructorTester;
import pl.pojo.tester.internal.tester.EqualsTester;
import pl.pojo.tester.internal.tester.GetterTester;
import pl.pojo.tester.internal.tester.HashCodeTester;
import pl.pojo.tester.internal.tester.SetterTester;
import pl.pojo.tester.internal.tester.ToStringTester;

/**
 * Declares methods that can be tested using POJO-TESTER.
 * <p>
 * For more documentation, please refer <a href="http://pojo.pl">POJO-TESTER User Guide documentation</a>
 *
 * @author Piotr Joński
 * @since 0.1.0
 */
public enum Method {
    EQUALS(EqualsTester.class),
    HASH_CODE(HashCodeTester.class),
    SETTER(SetterTester.class),
    GETTER(GetterTester.class),
    TO_STRING(ToStringTester.class),
    CONSTRUCTOR(ConstructorTester.class);

    private final Class<? extends AbstractTester> testerClass;

    Method(final Class<? extends AbstractTester> tester) {
        this.testerClass = tester;
    }

    public AbstractTester getTester() {
        try {
            return testerClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new TesterInstantiationException(e);
        }
    }
}
