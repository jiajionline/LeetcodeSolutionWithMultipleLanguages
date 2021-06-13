/**
 * @param {string} s
 * @return {boolean}
 */
 var isValid = function(s){
    
    if(s.length % 2 == 1) return false;
    
    const stack = []

    for (i=0; i < s.length; i++){

        let curr = s[i];
        
        switch(curr) {
            case '(': stack.push(')');
                break;
            case '[': stack.push(']');
                break;
            case '{': stack.push('}')
                break;
            default:
                elem = stack.pop()
                if (curr !== elem) return false;       
        }
    }
    return stack.length === 0;
}