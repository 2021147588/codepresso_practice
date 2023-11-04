<style>
	/* Twitter-like header styles */

	/* Navbar */
	.navbar {
		background-color: #1da1f2;
		padding: 10px 0;
	}

	.navbar-brand {
		color: white;
		font-weight: bold;
		font-size: 24px;
		padding-left: 10px;
	}

	/* Buttons */
	.btn {
		border: none;
		border-radius: 20px;
		font-weight: bold;
		text-transform: uppercase;
		margin-left: 10px;
	}

	.btn-secondary {
		background-color: #1da1f2;
		color: white;
	}

	.btn-secondary:hover {
		background-color: #0d91e5;
	}

	/* Logout button */
	#header_logout_btn {
		background-color: transparent;
		color: white;
	}

	#header_logout_btn:hover {
		text-decoration: underline;
	}

	/* Sign Up and Login buttons */
	#header_signup_btn,
	#header_login_btn {
		background-color: transparent;
		color: white;
		border: 1px solid white;
	}

	#header_signup_btn:hover,
	#header_login_btn:hover {
		background-color: transparent;
		color: #1da1f2;
		border: 1px solid #1da1f2;
	}
</style>

<nav class="navbar navbar-expand-lg fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/">Kwikker</a>
		<#if member??>
		<div class="row">
			<button class="btn btn-secondary mx-3" id="create_btn" data-toggle="modal"
			data-target="#create_post_modal">Create Post</button>
			<button class="btn" id="header_logout_btn">Logout</button>
		</div>
		<#else>
		<div class="row">
			<a href="/signup"><button class="btn btn-secondary mr-3" id="header_signup_btn">Sign Up</button></a>
			<a href="/login"><button class="btn btn-secondary" id="header_login_btn">Login</button></a>
		</div>
		</#if>
	</div>
</nav>