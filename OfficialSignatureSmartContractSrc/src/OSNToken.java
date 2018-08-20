// Official Signature Open Source - SmartContract SRC 
pragma solidity ^0.4.15;

public class OSNToken {

	uint256 public totalSupplyOSN;
	    function allowanceOSN(address _ownerOSN, address _spenderOSN) public constant returns (uint256 remainingOSN);
	    function Transfer_OSN(address _toOSN, uint256 _valueOSN) public returns (bool successOSN);
	    function balanceOfOSN(address _ownerOSN) public constant returns (uint256 balanceOSN);
	    function approveOSN(address _spenderOSN, uint256 _valueOSN) public returns (bool successOSN);
	    function Transfer_OSNFrom(address _fromOSN, address _toOSN, uint256 _valueOSN) public returns (bool successOSN);
	    event Transfer_OSN(address indexed _fromOSN, address indexed _toOSN, uint256 _valueOSN);
	    event ApprovalOSN(address indexed _ownerOSN, address indexed _spenderOSN, uint256 _valueOSN);
	
	
}
