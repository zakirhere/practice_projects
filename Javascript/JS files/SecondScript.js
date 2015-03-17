var secondScript = "global";

function printValue() {
	secondScript = "Printing from second script";
	return secondScript;
}

function printGlobal() {
	return secondScript;
}