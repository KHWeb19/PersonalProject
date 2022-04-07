<template>
    <div>
      <v-container style="width: 750px; margin-top: 20px; padding-left: 0px">
      <v-flex>
          <v-card style="height: 600px">
          <br/>
          <div style="display: flex; justify-content: center;">
          <form @submit.prevent="onSubmit"  >
            <table>
              <tr>
                  <td style="text-align: right; padding-right: 10px">                    
                    <v-img style=" margin-left: 25px" width="38" src="@/assets/logo.png"/>
                  </td>
                  <td style="padding-left: 10px">
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
                    height: 35px;
                    padding-left: 5px;" 
                    type="text" v-model="memberName" />
                  </td>
              </tr>
              <tr>
                  <td></td>
                  <td style="width: 300px; font-size: 12px; padding-top: 10px">사람들이 이름, 별명 또는 비즈니스 이름 등 회원님의 알려진 이름을 사용하여 회원님의 계정을 찾을 수 있도록 도와주세요.</td>
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
                    height: 35px;
                    padding-left: 5px;" 
                    type="text" v-model="memberId"  />
                  </td>
              </tr>
              <br/>
              <tr>
                  <td style="text-align: right; padding-right: 10px">웹사이트</td>
                  <td>
                    <input style="
                    margin: 3px;
                    border: 1px solid #d6d6d6; 
                    border-radius: 3px; 
                    width: 300px; 
                    height: 35px;
                    padding-left: 5px;" 
                    type="text" placeholder="웹사이트" v-model="memberWeb"/>
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
                      min-height: 70px;
                      padding-left: 5px;" 
                  type="text" placeholder="소개" v-model="memberIntro">
                  </textarea>
                  </td>
              </tr>
            </table>
            <br/>
            <div style="text-align: center">
              <v-btn style="height: 30px;" color="blue" class="white--text" type="submit">제출</v-btn>
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
export default {
    name: 'AccountsEditForm',
    props: {
      member: {
        type: Object,
        require:true
      }
    },
    data() {
      return {
        memberName: '',
        memberId: ''
      }
    },
    methods: {
      onSubmit() {
        const { memberName, memberId, memberWeb, memberIntro } = this
        this.$emit('submit', { memberName, memberId, memberWeb, memberIntro})
      }
    },
    created() {
      this.memberName = this.member.memberName
      this.memberId = this.member.memberId
      this.memberWeb = this.member.memberWeb
      this.memberIntro = this.member.memberIntro
    }

}
</script>

<style scoped>


.filebox input { 
  position: absolute; clip:rect(0,0,0,0);
}




</style>