new Vue({
    el:"#my",
        data:{
            users:{
            },

        },
        created:function () {
            this.findAll();
        },
        methods:{
        findAll:function () {
            var _this = this;
            axios.get('/GetUser', {
                params: {
                    p_id: -1
                }
            })
                .then(function (value) {
                    _this.users=value.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
            update:function () {
            var _this = this;
                let sex = $('input:radio:checked').val();
                let name = $('#name').val();
                let email = $('#email').val();
                let hobby = $('#hobby').val();
            axios.get('/UdpUser', {
                params: {
                    sex: sex,
                    u_name:name,
                    email:email,
                    hobby:hobby
                }
            })
                .then(function (value) {
                    alert(value.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

    }
})



// vue1.findAll(66)

