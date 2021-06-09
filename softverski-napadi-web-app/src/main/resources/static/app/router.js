
const HomePage = { template: '<HomePage></HomePage>' }
const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	   
	    { 
	    	path: '/', 
	    	name : 'HomePage', 
			components: {
				content: HomePage
			}
	    }
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});