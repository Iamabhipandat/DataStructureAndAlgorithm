
const expect = function(val) {
  function toBe(val1){
    if(val===val1){
        return true;
    }else{
      throw new Error("Not Equal");
    }
  }
  function notToBe(val1){
    if(val!==val1){
        return true;
    }else{
        throw new Error("Equal");
    }
  }
     return {
        notToBe: notToBe,
        toBe: toBe
    };
    }

