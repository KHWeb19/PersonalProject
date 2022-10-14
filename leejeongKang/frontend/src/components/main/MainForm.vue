<template>
    <body><br>
        <h1><router-link style="color: black" :to="{ name: 'MainPage'}">
          &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<v-icon id="icon" left size="80px">mdi-hospital-box</v-icon>바로 병원
        </router-link></h1>
        <div id = "menu" v-if="this.$store.state.userInfo">
        <router-link style="color: gray" :to="{ name: 'MyPage' }">
                    마이페이지&emsp;
        </router-link>
        <a @click="logout" style="color:gray">
                로그아웃
                <v-icon left>
                mdi-logout
                </v-icon>
        </a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        </div>
        <div id = "menu" v-else>
        <router-link style="color: gray" :to="{ name: 'LoginPage'}">
                    로그인&emsp;&emsp;
        </router-link>
        <router-link style="color: gray" :to="{ name: 'MemberRegisterPage'}">
                    회원가입&emsp;&emsp;
        </router-link>
        </div>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<br>
        <hr color ="#DCDCDC" width="100%">
      <div id="toolbar">
      <v-toolbar flat app color="#DCDCDC" height="80px">
        <v-spacer></v-spacer>
          <router-link style="color: gray" :to="{ name: 'DepartListPage'}">진료 예약
        </router-link>&emsp;&emsp;&emsp;&emsp;
         <router-link style="color: gray" :to="{ name: 'CheckAppointmentPage'}">예약 조회 / 취소
         </router-link>&emsp;&emsp;&emsp;&emsp;
         <router-link style="color: gray"  :to="{ name: 'BoardListPage'}">고객의 소리
        </router-link>&emsp;&emsp;&emsp;&emsp;
        <v-spacer></v-spacer>
    </v-toolbar><br><br>
      </div>
    </body>
</template>
<script>
export default {
  name: "MainPage.vue",
  props: {
    member: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      isLogin: false
    }
  },
  computed: {
    cookie () {
      return document.cookie
    }
  },
  mounted () {
    this.$store.state.userInfo = this.$cookies.get("user")
    if (this.$store.state.userInfo != null) {
      this.isLogin = true
    }
  },
  methods: {
    logout () {
      this.$cookies.remove("user")
      this.isLogin = false
      this.$store.state.userInfo = null
      localStorage.removeItem("userInfo")
      alert('로그아웃 성공!')
      this.$router.replace("/main")
    }
  }
}
</script>

<style scoped>
a { text-decoration: none; font-size: 28px; text-align: center; color: gray; }
#menu { padding: 15px; text-align: right; }
#icon { color: navy; size: 65px;}
#toolbar { text-align: center; }
h1 { line-height: 60px; float: left;}
</style>
