<template>
    <div>
      <v-container style="width: 700px; margin-top: 85px; padding-left: 0px">
        <v-flex >
          <v-card style="height: 620px">
            <div style="display: flex; justify-content: center; padding-top: 25px; padding-bottom:20px">
              <td style="padding-left: 120px;  margin: 6px 0px 0px 62px;">
                <div style="border-radius: 70%; overflow: hidden;">
                  <v-img v-if="priview" width="38" :src="priview"/>
                  <v-img v-else-if="member.imageName" width="38" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                  <v-img v-else width="38" src="@/assets/profile.jpg"/>
                </div>
              </td>
              <td style="margin-left: 15px;"> 
                {{member.memberId}}
                <br/>
                <label for="files">
                    프로필 사진 바꾸기
                </label>
                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()"/>
              </td>
            </div>
            <div style="display: flex; justify-content: center;">
            <form @submit.prevent="onSubmit">
              <table>
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
                    <td style="width: 300px; color: grey; font-size: 12px; padding: 5px 0px 0px 5px">사람들이 이름, 별명 또는 비즈니스 이름 등 회원님의 알려진 이름을 사용하여 회원님의 계정을 찾을 수 있도록 도와주세요.</td>
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
                <br/>
                <tr>
                    <td></td>
                    <td style="color: grey; font-size: 12px; padding: 0px 0px 5px 5px">공개 프로필에는 포함되지 않습니다.</td>
                </tr>
                <tr>
                    <td style="text-align: right; padding-right: 10px">비밀번호 힌트</td>
                    <td>
                      <input style="
                      margin: 3px;
                      border: 1px solid #d6d6d6; 
                      border-radius: 3px; 
                      width: 300px; 
                      height: 35px;
                      padding-left: 5px;" 
                      type="text" placeholder="ex) 좋아하는 색깔" v-model="passwordHint"/>
                    </td>
                </tr>
                
              </table>
              <div style="text-align: center; padding-top: 26px">
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
import axios from 'axios'
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
        files: '',
        priview: '',
        imageName: '',
        memberName: '',
        memberId: '',
        loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
      }
    },
    methods: {
      handleFileUpload () {
            this.files = this.$refs.files.files
            this.priview = URL.createObjectURL(this.files[0])
        },
      onSubmit() {
        let formData = new FormData()
          for (let idx = 0; idx < this.files.length; idx++) {
              formData.append('fileList', this.files[idx])
          }
          axios.post('http://localhost:7777/member/uploadImg', formData, {
              headers: {
                  'Content-Type': 'multipart/form-data',
              }
          })
          .then (() => {
              // alert('처리 결과: ' + res.data)
              console.log(this.files[0].name)
              this.imageName = this.files[0].name
              //
              const { memberName, memberId, imageName, memberWeb, memberIntro, passwordHint } = this
              this.$emit('submit', { memberName, memberId, imageName, memberWeb, memberIntro, passwordHint})
              localStorage.setItem("imageChange", JSON.stringify(imageName))
          })
          .catch (() => {
              // alert('처리 결과: ' + res.message)
              this.imageName = this.member.imageName
              const { memberName, memberId, imageName, memberWeb, memberIntro, passwordHint } = this
              this.$emit('submit', { memberName, memberId, imageName, memberWeb, memberIntro, passwordHint})
          })
      }
    },
    created() {
      this.memberName = this.member.memberName
      this.memberId = this.member.memberId
      this.imageName = this.member.imageName
      this.memberWeb = this.member.memberWeb
      this.memberIntro = this.member.memberIntro
      this.passwordHint = this.member.passwordHint
    }

}
</script>

<style scoped>
label {
    color: blue;
}

/* 못생긴 기존 input 숨기기 */
#files {
    visibility: hidden;
}

</style>