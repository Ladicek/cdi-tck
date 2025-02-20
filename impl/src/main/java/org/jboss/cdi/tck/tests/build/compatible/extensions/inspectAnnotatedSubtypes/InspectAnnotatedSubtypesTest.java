package org.jboss.cdi.tck.tests.build.compatible.extensions.inspectAnnotatedSubtypes;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.cdi.tck.AbstractTest;
import org.jboss.cdi.tck.cdi.Sections;
import org.jboss.cdi.tck.shrinkwrap.WebArchiveBuilder;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

@SpecVersion(spec = "cdi", version = "4.0")
public class InspectAnnotatedSubtypesTest extends AbstractTest {
    @Deployment
    public static WebArchive createTestArchive() {
        return new WebArchiveBuilder()
                .withTestClassPackage(InspectAnnotatedSubtypesTest.class)
                .withBuildCompatibleExtension(InspectAnnotatedSubtypesExtension.class)
                .build();
    }

    @Test
    @SpecAssertion(section = Sections.ENHANCEMENT_PHASE, id = "c", note = "MyServiceBar not seen by extension method")
    @SpecAssertion(section = Sections.VALIDATION_PHASE, id = "a", note = "Validation determine test outcome")
    public void test() {
        // test is present in InspectAnnotatedSubtypesExtension and if it fails, deployment should fail
    }
}
