<template>
  <v-dialog persisten max-width="400px">
      <template v-slot:activator="{ on }">
            <v-btn color="amber lighten-2" style="font-size: 0.7em; padding:1px;" dark v-on="on" @click="logout()" text>
                <v-icon style="font-size: 1.5em;">
                    mdi-logout
                </v-icon>
                Logout
            </v-btn>  
        </template>

  </v-dialog>
</template>


<script>
export default {
    name: 'MemberLogout',
    methods: {
         logout () {
            this.$cookies.remove("user")
            this.$store.state.isLogin = false
            this.$store.state.userInfo = null
            localStorage.removeItem('vuex');
    
            

        alert('로그아웃 성공!')
         this.$router.push({
         name: 'HomeView'
         })
        }
    }
    
}
</script>