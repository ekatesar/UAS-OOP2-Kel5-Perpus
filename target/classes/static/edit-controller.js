cobaApp.controller('EditController', 
	    function($scope, $http, $window) {

	$scope.prps = {};

	$scope.simpan = function() {
		
		$http.post('/simpan', $scope.prps).then(sukses, gagal);

		function sukses(response) {
			$window.location.href = "/";
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.batal = function() {
		$window.location.href = "/";
	};

	$scope.muat = function() {
		var id = $window.location.search.split("=")[1];
		$scope.prps.id = id;

		$http.get('/ambil-data-prps/' + id).then(sukses, gagal);

		function sukses(response) {
			//console.log(response.data);
			$scope.prps = response.data;
		};

		function gagal(response) {};

	};

	$scope.muat();

});