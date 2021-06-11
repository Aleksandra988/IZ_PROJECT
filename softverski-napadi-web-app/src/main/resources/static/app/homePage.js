Vue.component("HomePage", {
	data: function () {
		return {
			
	}
	},
	mounted() {
		document.getElementById('s1').disabled=true
		document.getElementById('s2').disabled=true
		document.getElementById('s3').disabled=true
		document.getElementById('s4').disabled=true
		document.getElementById('s5').disabled=true
		document.getElementById('s6').disabled=true
		document.getElementById('s7').disabled=true
		document.getElementById('s8').disabled=true
		document.getElementById('s9').disabled=true
		document.getElementById('s10').disabled=true
		document.getElementById('s11').disabled=true
		document.getElementById('s12').disabled=true
		document.getElementById('s13').disabled=true
		document.getElementById('s14').disabled=true
		document.getElementById('s15').disabled=true
		document.getElementById('s16').disabled=true
		document.getElementById('s17').disabled=true
		document.getElementById('s18').disabled=true
		document.getElementById('s19').disabled=true
		document.getElementById('s20').disabled=true
		document.getElementById('s21').disabled=true
		document.getElementById('s22').disabled=true
		document.getElementById('s23').disabled=true
		document.getElementById('s24').disabled=true
		document.getElementById('s25').disabled=true
		document.getElementById('s26').disabled=true
	},
	template: `
		<div style="margin-top: 100px;margin-left: 30%;auto;">
			<div>
			<label class="form-check-label" style="margin-left: 5%;width:380px;font-weight: bold;"">
				Atributes:
			</label>
			<label class="form-check-label" style="font-weight: bold;">
					State:
			</label>
			</div><br><br>

			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="1" v-on:click="SlectDis('1')">
				<label class="form-check-label" style="width:350px;">
				Vulnerable functions
				</label>
				<select id="s1" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Exposed</option>
					<option value="2">Not exposed</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="2" v-on:click="SlectDis('2')">
				<label class="form-check-label" style="width:350px;">
				Scrubbing of sensitive data
				</label>
				<select id="s2" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Yes</option>
					<option value="2">No</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="3" v-on:click="SlectDis('3')">
				<label class="form-check-label" style="width:350px;">
				Authorization	
				</label>
				<select id="s3" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Proper</option>
					<option value="2">Improper</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="4" v-on:click="SlectDis('4')">
				<label class="form-check-label" style="width:350px;">
				Encryption
				</label>
				<select id="s4" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Yes</option>
					<option value="2">No</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="5" v-on:click="SlectDis('5')">
				<label class="form-check-label" style="width:350px;">
				Zeroization of hardware register
				</label>
				<select id="s5" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Proper</option>
					<option value="2">Improper</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="6" v-on:click="SlectDis('6')">
				<label class="form-check-label" style="width:350px;">
				Interacting with system
				</label>
				<select id="s6" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Yes</option>
					<option value="2">No</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="7" v-on:click="SlectDis('7')">
				<label class="form-check-label" style="width:350px;">
				Authentication
				</label>
				<select id="s7" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Proper</option>
					<option value="2">Improper</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="8" v-on:click="SlectDis('8')">
				<label class="form-check-label" style="width:350px;">
				Permission assignment for critical resource
				</label>	
				<select id="s8" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Correct</option>
					<option value="2">Incorrect</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="9" v-on:click="SlectDis('9')">
				<label class="form-check-label" style="width:350px;">
				Code book
				</label>
				<select id="s9" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">In use</option>
					<option value="2">Not in use</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="10" v-on:click="SlectDis('10')">
				<label class="form-check-label" style="width:350px;">
				Input validation
				</label>
				<select id="s10" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Proper</option>
					<option value="2">Improper</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="11" v-on:click="SlectDis('11')">
				<label class="form-check-label" style="width:350px;">
				Covert timing channel
				</label>
				<select id="s11" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">In use</option>
					<option value="2">Not in use</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="12" v-on:click="SlectDis('12')">
				<label class="form-check-label" style="width:350px;">
				Forgery protection
				</label>
				<select id="s12" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Exists</option>
					<option value="2">Not exists</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="13" v-on:click="SlectDis('13')">
				<label class="form-check-label" style="width:350px;">
				Likelihood
				</label>
				<select id="s13" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Low</option>
					<option value="2">Medium</option>
					<option value="2">High</option>
					<option value="2">Very high</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="14" v-on:click="SlectDis('14')">
				<label class="form-check-label" style="width:350px;">
				Typical severity
				</label>
				<select id="s14" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Low</option>
					<option value="2">Medium</option>
					<option value="2">High</option>
					<option value="2">Very high</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="15" v-on:click="SlectDis('15')">
				<label class="form-check-label" style="width:350px;">
				Code obfuscation techniques
				</label>
				<select id="s15" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">In use</option>
					<option value="2">Not in use</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="16" v-on:click="SlectDis('16')">
				<label class="form-check-label" style="width:350px;">
				White box analysis techniques
				</label>
				<select id="s16" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Yes</option>
					<option value="2">No</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="17" v-on:click="SlectDis('17')">
				<label class="form-check-label" style="width:350px;">
				Black box analysis techniques
				</label>
				<select id="s17" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Yes</option>
					<option value="2">No</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="18" v-on:click="SlectDis('18')">
				<label class="form-check-label" style="width:350px;">
				Communication paths
				</label>
				<select id="s18" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Trusted</option>
					<option value="2">Untrusted</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="19" v-on:click="SlectDis('19')">
				<label class="form-check-label" style="width:350px;">
				Configuration
				</label>
				<select id="s19" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Good</option>
					<option value="2">Bad</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="20" v-on:click="SlectDis('20')">
				<label class="form-check-label" style="width:350px;">
				Privilege management
				</label>
				<select id="s20" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Proper</option>
					<option value="2">Improper</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="21" v-on:click="SlectDis('21')">
				<label class="form-check-label" style="width:350px;">
				Security checks
				</label>
				<select id="s21" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Yes</option>
					<option value="2">No</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="22" v-on:click="SlectDis('22')">
				<label class="form-check-label" style="width:350px;">
				Signal level alerts
				</label>
				<select id="s22" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Yes</option>
					<option value="2">No</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="23" v-on:click="SlectDis('23')">
				<label class="form-check-label" style="width:350px;">
				Server version
				</label>
				<select id="s23" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">New</option>
					<option value="2">Old</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="24" v-on:click="SlectDis('24')">
				<label class="form-check-label" style="width:350px;">
				Hardware
				</label>
				<select id="s24" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Trusted</option>
					<option value="2">Untrusted</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="25" v-on:click="SlectDis('25')">
				<label class="form-check-label"  style="width:350px;">
				Expiration
				</label>
				<select id="s25" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">New</option>
					<option value="2">Old</option>
				</select>
			</div><br>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" id="26" v-on:click="SlectDis('26')">
				<label class="form-check-label" style="width:350px;">
				Password policy
				</label>
				<select id="s26" class="form-select">
					<option selected disabled>Open this select menu</option>
					<option value="1">Strong</option>
					<option value="2">Week</option>
				</select>
			</div><br><br>
			<button v-on:click="Find()">Find attacks</button><br><br><br><br>
		</div>
	`,
	methods: {
		SlectDis: function(br)
		{
			if(document.getElementById(br).checked)
				return document.getElementById('s'+br).disabled=false
			return document.getElementById('s'+br).disabled=true
		},
		Find:function(){
			
		}
    }
});

