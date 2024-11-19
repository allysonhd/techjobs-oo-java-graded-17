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
        assertEquals("ACME", jobA.getEmployer().toString());
        assertEquals("Desert", jobA.getLocation().toString());
        assertEquals("Quality control", jobA.getPositionType().toString());
        assertEquals("Persistence", jobA.getCoreCompetency().toString());

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
               "ID: " + jobA.getId() + "\n" +
               "Name: " + jobA.getName() + "\n" +
               "Employer: " + jobA.getEmployer() + "\n" +
               "Location: " + jobA.getLocation() + "\n" +
               "Position Type: " + jobA.getPositionType() + "\n" +
               "Core Competency: " + jobA.getCoreCompetency() + "\n"));
   }
   
   @Test
    public void testToStringHandlesEmptyField() {
       Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
               new PositionType("Quality control"), new CoreCompetency("Persistence"));

       if (jobA.getName().toString().isEmpty()) {
           jobA.setName("Data not available");
       }
       if (jobA.getEmployer().toString().isEmpty()) {
           jobA.getEmployer().setValue("Data not available");
       }
       if (jobA.getLocation().toString().isEmpty()) {
           jobA.getLocation().setValue("Data not available");
       }
       if (jobA.getPositionType().toString().isEmpty()) {
           jobA.getPositionType().setValue("Data not available");
       }
       if (jobA.getCoreCompetency().toString().isEmpty()) {
           jobA.getCoreCompetency().setValue("Data not available");
       }
   }
}
