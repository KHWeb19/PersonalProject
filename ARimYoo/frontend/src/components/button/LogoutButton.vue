<template>
    <div>
    
        <v-btn
            color="white"
            height="20"
            @click="logout"
        >
            Logout
          </v-btn>

    </div>
</template>

<script>
export default {
    name:  'LogoutButton',
    methods: {
        logout() {
            this.$cookies.remove("user")
            this.$store.state.userInfo = null
            alert ('로그아웃되셨습니다.')
        }
    }
}
</script>