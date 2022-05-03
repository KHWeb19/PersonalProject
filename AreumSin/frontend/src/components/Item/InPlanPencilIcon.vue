<template>
  <v-row>
    <v-col>
      <v-btn fab class="float-right">
        <v-menu offset-y  dense style="height: 60px">
          <template v-slot:activator="{ on }">
            <v-btn v-on="on" fab>
              <v-icon x-large>mdi-lead-pencil</v-icon>
            </v-btn>
          </template>

          <v-list>
            <v-list-item-group>
              <v-list-item>
                <v-list-item-content>
                  <v-list-item-title @click="showDialog" style="font-size: 30px">친구 초대</v-list-item-title>
                </v-list-item-content>
              </v-list-item>

              <v-list-item>
                <v-list-item-content>
                  <v-list-item-title @click="showDialogVote" style="font-size: 30px">투표 만들기</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-menu>
      </v-btn>

      <v-dialog max-width="800" v-model="inviteFriend">
        <v-card>
          <v-card-title>
            <span style="font-size: 40px; color: darkolivegreen"><br/>친구 초대</span>
          </v-card-title>

          <v-card-text>
            <v-container>
              <form>
                <table>
                  <tr>
                    <td colspan="2">&nbsp;&nbsp;<input class="inputBox" type="text" placeholder="write friendId!" v-model="friendId" required><v-btn @click="onSubmit">검색</v-btn></td>
                  </tr>

                  <tr v-if="findName === null">
                    <td>
                      검색 해주세요
                    </td>
                  </tr>

                  <tr v-else-if="(findName === 'x')">
                    <td>찾는 사람이 없습니다.</td>
                  </tr>

                  <tr v-else>
                    <div v-if="isCheck" style="font-size: 25px">
                      <td>
                        id&nbsp;:&nbsp;<input type="text" style="width: 50px" :value="findId" readonly> &nbsp;
                      </td>
                      <td>
                        이름&nbsp;:&nbsp;<input type="text" :value="findName" readonly>
                      </td>
                      <td>
                        <v-btn @click="addFriend" class="orange white--text">친구 추가</v-btn>
                      </td>
                    </div>
                  </tr>

                </table>
              </form>
            </v-container>

          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green darken-1" text @click="closeDialog()">Close</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>

      <v-dialog max-width="800" v-model="voteDialog">
        <v-card class="pa-10">
          <v-row justify="start">
            <v-btn @click="closeVoteDialog()"> x </v-btn>
          </v-row>

          <v-row justify="center">
            <v-card-title>
              <span style="font-size: 40px; color: darkolivegreen"><br/>어떤걸 투표할까요?!</span>
            </v-card-title>
          </v-row>

          <v-row justify="center">
            <form>
              <table>
                <tr style="width: 100%">
                  <td><input type="text" style="border: black solid 1px; height: 35px; width: 450px" v-model="vote"></td>
                </tr>
              </table>
            </form>
          </v-row>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green lighten-1" @click="sendVote">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-col>
  </v-row>
</template>

<script>

export default {
  name: "BeforePencilIcon",
  data() {
    return{
      inviteFriend: false,
      friendId: '',
      isCheck: true,
      voteDialog: false,
      vote: '',
    }
  },
  props:{
    id: {
      type: String,
    },
    findId: {
      type: String,
    },
    findName: {
      type: String,
    }
  },
  methods: {
    showDialog() {
      this.inviteFriend = true
    },
    showDialogVote(){
      this.voteDialog = true
    },
    onSubmit(){
      const {friendId} = this;
      //console.log({friendId});
      this.$emit('submit',{friendId});
      this.isCheck = true;
    },
    sendVote(){
      const {vote} = this;
      this.$emit('sendVote', {vote})
      this.voteDialog = false;
    },
    addFriend(){
      const {friendId} = this;
      this.isCheck = false;
      this.$emit('addSubmit', {friendId})
    },
    closeDialog(){
      this.inviteFriend = false;
      this.friendId = null;
      this.isCheck = false;

    },
    closeVoteDialog(){
      this.voteDialog = false;
    }
  },
  computed: {

  },
}
</script>

<style scoped>
table {
  border-collapse:  separate;
  border-spacing: 0 1rem;
}
.plan{
  font-size: 30px;
}
input{
  font-size: 20px;
}
/*td{
  border: 1px solid black;
  font-size: 20px;
}*/

</style>