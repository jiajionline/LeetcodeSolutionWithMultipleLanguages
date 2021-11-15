public class Solution {
    public int NumUniqueEmails(string[] emails) {
        var set = new HashSet<string>();
        foreach(var email in emails)
        {
            if(string.IsNullOrWhiteSpace(email)) continue;
            var str = email.Trim();
            if(str[0] == '.' || str[0] == '+') continue;
            set.Add(NormalizeEmail(str));
        }
        
        return set.Count;
    }
    
    private string NormalizeEmail(string email)
    {
        var email_arr = email.Split('@');
        var sb = new StringBuilder();
        foreach(var c in email_arr[0])
        {
            if(c == '.') continue;
            else if(c == '+') break;
            else sb.Append(c);
        }
        
        sb.Append('@');
        sb.Append(email_arr[1]);
        
        return sb.ToString();
    }
}