import models.Person;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestDrooles {
    public static void main(String[] args) {
        System.out.println("Hello");
        TestDrooles testDrooles = new TestDrooles();
        WorkingMemory session = null;
        try {
            session = testDrooles.executeDrools();
        } catch (DroolsParserException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }

        Person person = new Person("Synerzip", 1);
//        person.setName("Synerzip");
//        person.setTime(10);
        if (session != null){
            session.insert(person);
            session.fireAllRules();
        }

        System.out.println(person.getGreet());
    }

    private WorkingMemory executeDrools() throws DroolsParserException, IOException {
        String ruleFile = "rules/droolsRule.drl";
        InputStream ruleStream = getClass().getResourceAsStream(ruleFile);
        Reader reader = new InputStreamReader(ruleStream);

        PackageBuilder packageBuilder = new PackageBuilder();
        packageBuilder.addPackageFromDrl(reader);
        Package rulePackage = packageBuilder.getPackage();

        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(rulePackage);

        return ruleBase.newStatefulSession();
    }
}
