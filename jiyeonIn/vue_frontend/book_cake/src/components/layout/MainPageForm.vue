<template>
    <div class="Main">
        <header>
            <v-container v-if="checkuserInfo == null">
                <v-row>
                    <v-col class="col-12 col-sm-10">
                    </v-col>
                    <v-col class="col-12 col-sm-1">
                        <router-link :to="{name: 'LoginPage'}" >
                            <span class="mainlog">로그인 </span>
                        </router-link>
                    </v-col>
                    <v-col class="col-12 col-sm-1">
                        <router-link :to="{name: 'SignUpPage'}" >
                            <span class="mainlog">회원가입</span>
                        </router-link>
                    </v-col>
                </v-row>
            </v-container>

            <v-container v-if="checkuserInfo != null">
                <v-row>
                    <v-col class="col-12 col-sm-10">
                        <span>{{id}}님, 안녕하세요</span>
                    </v-col>
                    <v-col class="col-12 col-sm-1">
                        <button @click="logout" type="submit" style="font-size: small; color: black;">로그아웃 </button>
                    </v-col>
                    <v-col class="col-12 col-sm-1">
                        <router-link :to="{name: 'MyPage'}" >
                            <span style="font-size: small; color: black;">My페이지</span>
                        </router-link>
                    </v-col>
                </v-row>
            </v-container>
            
            
            <router-link style="text-decoration: none;" :to="{name: 'MainHomepage'}" >            
                <v-img class="MainLogo"
                max-height="200" max-width="250" 
                src="@/assets/img/check.png"/>
            </router-link>
            
        </header>
        <hr>
         <v-container >
            <v-row no-gutters class="menu">
                <v-col class="col-12 col-sm-3"></v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'BookingPage'}">
                        <p>예약하기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'BookingListPage'}">
                        <p>주문서 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'PreviewCakeImg'}">
                        <p>케이크 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                   <router-link :to="{name: 'ReviewPage'}">
                        <p>후기</p>
                    </router-link>
                </v-col>
            </v-row>
        </v-container>

        
    </div>
</template>

<script>

    export default {
        name: 'MainPageForm',
        components: {
        },
        data () {
            return {
                checkuserInfo: window.localStorage.getItem('token'),
                id: (window.localStorage.getItem('id')),
            }
        },
        methods: {
            logout() {
                this.$cookies.remove("user")
                this.isLogin = false
                this.$store.state.userInfo = null
                window.localStorage.removeItem("token")
                alert('로그아웃 되었습니다!')
                this.$router.push({
                        name: 'LoginPage'
                    })
            }
        }

    }
    
</script>


<style scoped>

.Main {
    background: rgb(255, 186, 186);
    background-size : cover;
}

.MainLogo {
    display: block; margin: 0px auto;
}

.notice {
    background: rgb(253, 207, 207);
    border: 1px solid #ff6e6e;
    padding: 10px;
    width: 300;
}
.mainlog{
    font-size: small; 
    color: black;
    padding: 15px 0px 15px 0px;
}

ul{
    list-style: none; 
}

a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 700;
}
hr{ 
    background: #e69191;
    height: 3px;
}
</style>