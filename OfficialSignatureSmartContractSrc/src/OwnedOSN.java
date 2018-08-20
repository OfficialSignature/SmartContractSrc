
public class OwnedOSN {

	 modifier onlyOwnerOSN() {
	        require(msg.sender == ownerOSN);
	        _;
	    }

	    address public ownerOSN;

	    function OwnedOSN() public {
	        ownerOSN = msg.sender;
	    }

	    address newOwner=0x0;

	    event OwnerUpdate(address _prevOwner, address _newOwner);
	 
	    function changeOwnerOSN(address _newOwner) public onlyOwnerOSN {
	        require(_newOwner != ownerOSN);
	        newOwner = _newOwner;
	    }
	 
	   function acceptOwnership() public{
	        require(msg.sender == newOwner);
	        OwnerUpdate(ownerOSN, newOwner);
	        ownerOSN = newOwner;
	        newOwner = 0x0;
	    }
	        
}
