
public class Controll_OwnedOSN {
	function Controlled() public {
	       setExclude(msg.sender);
	    }
	 
	 
	    bool public Transfer_OSNEnabled = false;

	 
	    bool lockFlag=true;
	    mapping(address => bool) locked;
	    mapping(address => bool) exclude;

	    function enableTransfer_OSN(bool _enable) public onlyOwnerOSN{
	        Transfer_OSNEnabled=_enable;
	    }

	    function disableLock(bool _enable) public onlyOwnerOSN returns (bool successOSN){
	        lockFlag=_enable;
	        return true;
	    }

	    function addLock(address _addr) public onlyOwnerOSN returns (bool successOSN){
	        require(_addr!=msg.sender);
	        locked[_addr]=true;
	        return true;
	    }

	    function setExclude(address _addr) public onlyOwnerOSN returns (bool successOSN){
	        exclude[_addr]=true;
	        return true;
	    }

	    function removeLock(address _addr) public onlyOwnerOSN returns (bool successOSN){
	        locked[_addr]=false;
	        return true;
	    }

	    modifier Transfer_OSNAllowed(address _addr) {
	        if (!exclude[_addr]) {
	            assert(Transfer_OSNEnabled);
	            if(lockFlag){
	                assert(!locked[_addr]);
	            }
	        }
	        
	        _;
	    }
}
