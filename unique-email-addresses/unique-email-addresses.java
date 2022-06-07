class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] localParts = parts[0].split("\\+");
            String cleanLocal = localParts[0].replace(".", "");
            uniqueEmails.add(cleanLocal + '@' + parts[1]);
        }
        return uniqueEmails.size();
    }
}