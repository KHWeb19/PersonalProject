<template>
    <div>
    <menu-bar/>
      <v-container style="width: 500px; margin-top: 20px;">
      <v-flex>
        <v-card>
          <br/>
          <div style="display: flex; justify-content: center;">
          <form @submit.prevent="onSubmit"  >
            <table>
              <tr>
                  <td style="text-align: right; padding-right: 10px">                    
                    <v-img style=" margin-left: 25px" width="38" src="@/assets/logo.png"/>
                  </td>
                  <td>
                      {{member.memberId}}
                      <br/>
                      <div class="filebox"> 
                        <label style="cursor: pointer; color: blue" for="ex_file">프로필 사진 바꾸기</label>
                        <input type="file" id="ex_file"> 
                      </div>
                  </td>
              </tr>
              <br/>
              <tr>
                  <td style="text-align: right; padding-right: 10px">이름</td>
                  <td>
                    <input style="
                    margin: 3px;
                    border: 1px solid #d6d6d6; 
                    border-radius: 3px; 
                    width: 300px; 
                    height: 30px;
                    padding-left: 5px;" 
                    type="text" :value="member.memberName"/>
                  </td>
              </tr>
              <br/>
              <tr>
                  <td style="text-align: right; padding-right: 10px">아이디</td>
                  <td>
                      <input style="
                      margin: 3px;
                      border: 1px solid #d6d6d6; 
                      border-radius: 3px; 
                      width: 300px; 
                      height: 30px;
                      padding-left: 5px;" 
                  type="text" :value="member.memberId"/>
                  </td>
              </tr>
              <br/>
              <tr>
                  <td style="text-align: right; padding-right: 10px">비밀번호</td>
                  <td>
                      <input style="
                      margin: 3px;
                      border: 1px solid #d6d6d6; 
                      border-radius: 3px; 
                      width: 300px; 
                      height: 30px;
                      padding-left: 5px;" 
                  type="text" />
                  </td>
              </tr>
              <br/>
              <tr>
                  <td style="text-align: right; padding-right: 10px">소개</td>
                  <td>
                      <textarea style=" 
                      margin: 3px;
                      border: 1px solid #d6d6d6; 
                      border-radius: 3px; 
                      width: 300px; 
                      min-height: 60px;
                      padding-left: 5px;" 
                  type="text">
                  </textarea>
                  </td>
              </tr>
            </table>
            <br/>
            <div style="text-align: center">
              <v-btn style="width: 35px; height: 30px;" color="blue" class="white--text" type="submit">제출</v-btn>
            </div>
          </form>
          </div>
          <br/>
        </v-card> 
      </v-flex>
    </v-container>
  </div>    
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'

export default {
    name: 'AccountsEditForm',
    components: {
        MenuBar
    },
    props: {
      member: {
        type: Object,
        require:true
      }
    },
    // data() {
    //   return {
    //     memberName: '',
    //     memberId: ''
    //   }
    // },
    // methods: {
    //   onSubmit() {
    //     const {memberName, memberId} = this
    //     this.$emit('submit', {memberName, memberId})
    //   }
    // },
    // created() {
    //   this.memberName = this.member.memberName
    //   this.memberId = this.member.memberId
    // }

}
</script>

<style scoped>


.filebox input { 
  position: absolute; clip:rect(0,0,0,0);
}




</style>