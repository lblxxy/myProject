$(function () {
    layui.use(['table'],
        function() {
            let table = layui.table;
            table.render({
                elem: '#demo'
                ,height: 500
                ,url: '/meiman/admin/api/memberList'
                ,page: true
                ,text:"数据加载失败"
                ,autoSort:false
                ,cols: [[
                    {field: 'id', title: 'ID', width:'20%', fixed: 'left'}
                    ,{field: 'name', title: '用户名', width:'200'}
                    ,{field: 'role', title: '角色', width:'200'}
                ]]
                ,response:{
                    statusCode: "1000"
                }
                ,parseData: function(res){
                    console.log(res);
                    return {
                        "code": res.code,
                        "msg": res.msg,
                        "count": res.data.count,
                        "data": res.data.list
                    };
                }
            });
        });
});
