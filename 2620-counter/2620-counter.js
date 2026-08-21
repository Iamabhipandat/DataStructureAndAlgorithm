
var createCounter = function(n) {
    
    return function() {
        console.log(n)
        return n++;
        
    };
};
