<template>
    <v-dialog v-model="dialog" max-width="350">
      <template v-slot:activator="{ on }">
        <v-btn icon v-on="on" class="float-right">
          <v-icon color="secondary">Profile</v-icon>
        </v-btn>
      </template>

      <v-card class=" rounded-xl pa-4">
        <v-card-title>
          <p class="headline secondary--text font-weight-bold">
            {{ userInfo.name }}님 환영합니다!
          </p>
        </v-card-title>
        
        <v-card-text></v-card-text>
 
        <v-card-actions>
          <v-btn @click="btnLogout" class="secondary--text font-weight-bold" text >
            Logout
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnMypage" class="secondary--text font-weight-bold" text>
            Mypage
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      dialog: false
    }
  },
  computed: {
    ...mapState([ 'userInfo' ])
  },
  methods: {
    ...mapActions([ 'fetchSession' ]),

    btnLogout () {
      axios.post('http://localhost:7777/member/logout').then(res => {
        this.$store.commit('USER_LOGIN', res.data)
        this.fetchSession(this.$cookies.remove('session'))
        this.$store.commit('FETCH_USER_INFO', [])
      })
    },
    btnMypage () {
      this.$router.push({ name: `MyPage` })
    }
  }
}
</script>