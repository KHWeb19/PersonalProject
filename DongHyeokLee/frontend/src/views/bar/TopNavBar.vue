<template>
    <div>
        <v-toolbar v-if="!this.$store.state.isLogin" class="black" dense dark>
            <v-spacer></v-spacer>
            <v-toolbar-title>         
                <member-sign-up/>
                <member-login/>
            </v-toolbar-title>
        </v-toolbar>

        <v-toolbar v-if="this.$store.state.isLogin" class="black" dense dark>
            <v-spacer></v-spacer>
            <v-toolbar-title>         
                <member-my-page/>
                <member-logout/>
            </v-toolbar-title>
        </v-toolbar>
    </div>
</template>

<script>

import MemberSignUp from '@/views/member/MemberSignUp.vue'
import MemberLogin from '@/views/member/MemberLogin.vue'
import MemberLogout from '@/views/member/MemberLogout.vue'
import MemberMyPage from '@/views/member/MemberMyPage.vue'

export default {  
    name: 'TopNavBar',
    components: {
        MemberSignUp,
        MemberLogin,
        MemberLogout,
        MemberMyPage
    },
}
</script>
