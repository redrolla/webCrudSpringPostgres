function refreshUsersTable(){
    var url = '/users';

    $("#usersTable").load(url);
}