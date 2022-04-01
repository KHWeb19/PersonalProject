<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div>
            <div class="login" align="center">
                <login-page-form @submit="onSubmit"/>
            </div>
        </div>
        
        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import LoginPageForm from '@/components/mainPage/LoginPageForm.vue'
import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'
import FooterForm from '@/components/layout/FooterForm.vue'

Vue.use(cookies)

    export default {
        name: 'LoginPage',
        components: {
            LoginPageForm,
            MainPageForm,
                FooterForm
        },
        data () {
            return {
                isLogin: false
            }
        },
        mounted() {
            this.$store.state.userInfo = this.$cookies.get("user")

            if(this.$store.state.userInfo != null) {
                this.isLogin = true
            }else {
                this.isLogin = false
            }
        },
        methods: {
            onSubmit (payload) {
                if(!this.isLogin){
                    const {id, pw} = payload
                    axios.post('http://localhost:7777/Member/login', {id, pw})
                        .then(res => {
                            if(res.data) {
                                alert('안녕하세요!' +res.data.id+'님!')
                                this.$store.state.userInfo = res.data
                                this.$cookies.set("user", res.data, 3600)
                                this.isLogin = true
                                this.$router.push({
                                    name: 'MainHomepage'
                                })
                            }
                        })
                        .catch (() => {
                            alert('아이디 및 비밀번호를 잘못 입력하였습니다.')
                        })
                }else if(this.isLogin){
                     alert('이미 로그인 되어 있습니다!')
                    this.$router.push({
                        name: 'MainHomepage'
                    })
                }
            }   
        }
    }

</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.login {
    margin:0% 10% 0% 10%;
    padding: 15px;
}
a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 600;
}
hr{ 
    background: #e69191;
    height: 3px;
}
</style>