<template>
  <v-dialog v-model="dialog" max-width="350">
    <template v-slot:activator="{ on }">
      <v-btn class="pa-6" color="secondary" v-on="on" icon>
          <v-icon>mdi-delete</v-icon>
        </v-btn>
    </template>
    <v-card class="rounded-xl pa-4">
      <v-card-title class="secondary--text font-weight-bold">
        <p>정말 탈퇴하시겠습니까?</p>
      </v-card-title>

      <v-card-text></v-card-text>

      <v-card-actions>
        <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
          Cancle
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="btnRemove" class="secondary--text font-weight-bold" text>
          Delete
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
    btnCancle () {
      this.dialog = false
    },
    btnRemove () {
      const id = this.userInfo.id

      axios.delete(`http://localhost:7777/member/mypage/remove/${id}`).then(() => {
        
        this.$store.commit('USER_LOGIN', false)
        
        this.fetchSession(this.$cookies.remove('session'))

        this.$store.commit('FETCH_USER_INFO', [])
        
        alert('탈퇴가 완료되었습니다.')

        this.dialog = false
      })
    }
  }
}
</script>