
public class StandardOSNToken_Init {

	unction () public {
        revert();
    }

    string public name = "Official Signature";             
    uint8 public decimals = 18;               
    string public symbol = "OSN";       
    string public version = 'v0.2';     
    uint256 public allocateEndTime;

   
    mapping(address => uint256) nonces;

    function OSN() public {
        allocateEndTime = now + 1 days;
    }

    
}
