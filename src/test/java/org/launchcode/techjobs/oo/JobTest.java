package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
   Job jobA;
   Job jobB;

    //TODO: Create your unit tests here
   @Test
    public void testSettingJobId() {
        jobA = new Job();
        jobB = new Job();
       Assert.assertNotEquals(jobA, jobB);
   }
   @Test
    public void testJobConstructorSetsAllFields() {
      Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", jobA.getName());
        assertEquals("ACME", jobA.getEmployer().getValue());
        assertEquals("Desert", jobA.getLocation().getValue());
        assertEquals("Quality control", jobA.getPositionType().getValue());
        assertEquals("Persistence", jobA.getCoreCompetency().getValue());

        assertTrue(jobA.getName() instanceof String);
        assertTrue(jobA.getEmployer() instanceof Employer);
        assertTrue(jobA.getLocation() instanceof Location);
        assertTrue(jobA.getPositionType() instanceof PositionType);
        assertTrue(jobA.getCoreCompetency() instanceof CoreCompetency);
   }

   @Test
    public void testJobsForEquality() {

       Job jobA = new Job ("Product tester", new Employer("ACME"), new Location("Desert"),
               new PositionType("Quality control"), new CoreCompetency("Persistence"));

       Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
               new PositionType("Quality control"), new CoreCompetency("Persistence"));

       assertNotEquals(jobA, jobB);
   }

   @Test
    public void testToStringStartsAndEndsWithNewLine() {
       Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
               new PositionType("Quality control"), new CoreCompetency("Persistence"));
       assertTrue(jobA.toString().startsWith(System.lineSeparator()));
       assertTrue(jobA.toString().endsWith(System.lineSeparator()));
   }

   @Test
    public void testToStringContainsCorrectLabelsAndData() {
       Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
               new PositionType("Quality control"), new CoreCompetency("Persistence"));
       assertTrue(jobA.toString().contains(
               "ID: " + jobA.getId() + System.lineSeparator() +
               "Name: " + jobA.getName() + System.lineSeparator() +
               "Employer: " + jobA.getEmployer() + System.lineSeparator() +
               "Location: " + jobA.getLocation() + System.lineSeparator() +
               "Position Type: " + jobA.getPositionType() + System.lineSeparator() +
               "Core Competency: " + jobA.getCoreCompetency() + System.lineSeparator()));
   }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobA = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        assertTrue(jobA.toString().contains(
                "ID: " + jobA.getId() + System.lineSeparator() +
                        "Name: " + "Data not available" + System.lineSeparator() +
                        "Employer: " + "Data not available" + System.lineSeparator() +
                        "Location: " + "Data not available" + System.lineSeparator() +
                        "Position Type: " + "Data not available" + System.lineSeparator() +
                        "Core Competency: " + "Data not available" + System.lineSeparator()));
    }
}
