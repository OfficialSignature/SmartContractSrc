
public class StandardOSNToken {
	unction Transfer_OSN(address _toOSN, uint256 _valueOSN) public Transfer_OSNAllowed(msg.sender) returns (bool successOSN) {
	     
	    if (balances[msg.sender] >= _valueOSN && balances[_toOSN] + _valueOSN > balances[_toOSN]) {
	            balances[msg.sender] -= _valueOSN;
	            balances[_toOSN] += _valueOSN;
	            Transfer_OSN(msg.sender, _toOSN, _valueOSN);
	            return true;
	        } else { return false; }
	    }

	    function Transfer_OSNFrom(address _fromOSN, address _toOSN, uint256 _valueOSN) public Transfer_OSNAllowed(_fromOSN) returns (bool successOSN) {
	    
	    if (balances[_fromOSN] >= _valueOSN && allowed[_fromOSN][msg.sender] >= _valueOSN && balances[_toOSN] + _valueOSN > balances[_toOSN]) {
	            balances[_toOSN] += _valueOSN;
	            balances[_fromOSN] -= _valueOSN;
	            allowed[_fromOSN][msg.sender] -= _valueOSN;
	            Transfer_OSN(_fromOSN, _toOSN, _valueOSN);
	            return true;
	        } else { return false; }
	    }

	    function balanceOfOSN(address _ownerOSN) public constant returns (uint256 balanceOSN) {
	        return balances[_ownerOSN];
	    }

	    function approveOSN(address _spenderOSN, uint256 _valueOSN) public returns (bool successOSN) {
	        allowed[msg.sender][_spenderOSN] = _valueOSN;
	        ApprovalOSN(msg.sender, _spenderOSN, _valueOSN);
	        return true;
	    }

	    function allowanceOSN(address _ownerOSN, address _spenderOSN) public constant returns (uint256 remainingOSN) {
	      return allowed[_ownerOSN][_spenderOSN];
	    }

	    mapping (address => uint256) balances;
	    mapping (address => mapping (address => uint256)) allowed;
}
