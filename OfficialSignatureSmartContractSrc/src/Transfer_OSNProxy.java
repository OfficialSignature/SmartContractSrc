
public class Transfer_OSNProxy {

		function Transfer_OSNProxy(address _fromOSN, address _toOSN, uint256 _valueOSN, uint256 _OSNfee,
		        uint8 _v,bytes32 _r, bytes32 _s) public Transfer_OSNAllowed(_fromOSN) returns (bool){

		        if(balances[_fromOSN] < _OSNfee + _valueOSN) revert();

		        uint256 nonce = nonces[_fromOSN];
		        bytes32 h = keccak256(_fromOSN,_toOSN,_valueOSN,_OSNfee,nonce);
		        if(_fromOSN != ecrecover(h,_v,_r,_s)) revert();

		        if(balances[_toOSN] + _valueOSN < balances[_toOSN]
		            || balances[msg.sender] + _OSNfee < balances[msg.sender]) revert();
		        balances[_toOSN] += _valueOSN;
		        Transfer_OSN(_fromOSN, _toOSN, _valueOSN);

		        balances[msg.sender] += _OSNfee;
		        Transfer_OSN(_fromOSN, msg.sender, _OSNfee);

		        balances[_fromOSN] -= _valueOSN + _OSNfee;
		        nonces[_fromOSN] = nonce + 1;
		        return true;
		    }
		
		
		 function approveOSNProxy(address _fromOSN, address _spenderOSN, uint256 _valueOSN,
			        uint8 _v,bytes32 _r, bytes32 _s) public returns (bool successOSN) {

			        uint256 nonce = nonces[_fromOSN];
			        bytes32 hash = keccak256(_fromOSN,_spenderOSN,_valueOSN,nonce);
			        if(_fromOSN != ecrecover(hash,_v,_r,_s)) revert();
			        allowed[_fromOSN][_spenderOSN] = _valueOSN;
			        ApprovalOSN(_fromOSN, _spenderOSN, _valueOSN);
			        nonces[_fromOSN] = nonce + 1;
			        return true;
			    }



			    function getNonce(address _addr) public constant returns (uint256){
			        return nonces[_addr];
			    }
			    
			    function approveOSNAndCall(address _spenderOSN, uint256 _valueOSN, bytes _extraData) public returns (bool successOSN) {
			        allowed[msg.sender][_spenderOSN] = _valueOSN;
			        ApprovalOSN(msg.sender, _spenderOSN, _valueOSN);

			    if(!_spenderOSN.call(bytes4(bytes32(keccak256("receiveApprovalOSN(address,uint256,address,bytes)"))), msg.sender, _valueOSN, this, _extraData)) { revert(); }
			        return true;
			    }

			    function approveOSNAndCallcode(address _spenderOSN, uint256 _valueOSN, bytes _extraData) public returns (bool successOSN) {
			        allowed[msg.sender][_spenderOSN] = _valueOSN;
			        ApprovalOSN(msg.sender, _spenderOSN, _valueOSN);


			        if(!_spenderOSN.call(_extraData)) { revert(); }
			        return true;
			    }
			    
			    
			    function allocateTokens(address[] _owners, uint256[] _valuesOSN) public onlyOwnerOSN {

			        if(allocateEndTime < now) revert();
			        if(_owners.length != _valuesOSN.length) revert();

			        for(uint256 i = 0; i < _owners.length ; i++){
			            address to = _owners[i];
			            uint256 valueOSN = _valuesOSN[i];
			            if(totalSupplyOSN + valueOSN <= totalSupplyOSN || balances[to] + valueOSN <= balances[to]) revert();
			            totalSupplyOSN += valueOSN;
			            balances[to] += valueOSN;
			        }
			    }
			    
			    
			    
	

}
