package com.vivek;

import java.util.ArrayList;
import java.util.List;

abstract class Candidate {
    private String name;
    private int id;

    public Candidate(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Candidate [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeCandidate extends Candidate {
    private double monthlySalary;

    public FullTimeCandidate(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeCandidate extends Candidate {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeCandidate(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Candidate> CandidateList;

    public PayrollSystem() {
        CandidateList = new ArrayList<>();
    }

    public void addCandidate(Candidate Candidate) {
        CandidateList.add(Candidate);
    }

    public void removeCandidate(int id) {
        Candidate CandidateToRemove = null;
        for (Candidate Candidate : CandidateList) {
            if (Candidate.getId() == id) {
                CandidateToRemove = Candidate;
                break;
            }
        }
        if (CandidateToRemove != null) {
            CandidateList.remove(CandidateToRemove);
        }
    }

    public void displayCandidates() {
        for (Candidate Candidate : CandidateList) {
            System.out.println(Candidate);
        }
    }
}

/**
 * Hello world!
 *
 */
public class Payroll 
{ 
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeCandidate emp1 = new FullTimeCandidate("John Doe", 101, 5000.0);
        PartTimeCandidate emp2 = new PartTimeCandidate("Jane Smith", 102, 30, 15.0);

        payrollSystem.addCandidate(emp1);
        payrollSystem.addCandidate(emp2);

        System.out.println("Initial Candidate Details:");
        payrollSystem.displayCandidates();

        System.out.println("\nRemoving Candidate...");
        payrollSystem.removeCandidate(101);

        System.out.println("\nRemaining Candidate Details:");
        payrollSystem.displayCandidates();
    }
}
