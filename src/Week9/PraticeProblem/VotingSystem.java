package Week9.PraticeProblem;

// File: VotingSystem.java
public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            public boolean validate() {
                return voterId != null && voterId.startsWith("VOTER") && voterId.length() > 6;
            }
        }

        VoteValidator validator = new VoteValidator();
        if (validator.validate()) {
            System.out.println("Vote accepted for " + candidate);
        } else {
            System.out.println("Invalid Voter ID: " + voterId);
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.processVote("VOTER123", "Candidate A");
        vs.processVote("12345", "Candidate B");
    }
}
