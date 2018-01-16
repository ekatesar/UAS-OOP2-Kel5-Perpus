var cobaApp = angular.module('CobaApp', []);

cobaApp.controller('CobaController', 
	function($scope) {
		$scope.daftarNama = [];

		$scope.tambah = function() {
			$scope.daftarNama.push($scope.nama);
		}
	});

cobaApp.controller('ApiController', 
	    function($scope, $http, $window) {
	    	$scope.daftarPerpus = [];

	    	$scope.updateData = function() {
	    		$http.get('/daftar-perpus')
	    			.then(sukses, gagal);

	    		function sukses(response) {
	    			console.log(response);
	    			$scope.daftarPerpus = response.data;
	    		};	

	    		function gagal(response) {
	    			console.log(response);
	    		};
	    	};

	    	$scope.hapus = function(prps) {
	    		$http.delete('/hapus/' + prps.id).then(sukses, gagal);

	    		function sukses(response) {
	    			$scope.updateData();
	    		};

	    		function gagal(response) {};
	    	};


	    	$scope.ubah = function(prps) {
	    		//console.log(mhs);
	    		$window.location.href = "/edit?id=" + prps.id;
	    	};

	    	
	    	$scope.keluar = function() {
	    		$http.get('/logout').then(sukses, gagal);

	    		function sukses(response) {
	    			$window.location.href = "/login";
	    		}

	    		function gagal(response) {}
	    	};

	    	$scope.updateData();
		}
	);
