<template>
     <v-container class="align-content-center">
         <v-layout justify-center>
             <form @submit.prevent="onSubmit">
                <table>
                    <tr>
                        <td><img src="@/assets/form/formId.png" width="110" style="margin-left:60px"> </td>
                        <td>
                            <v-text-field filled single-line width="50" :value="userInfo.id"  disabled/>
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formPw.png" width="140" style="margin-left:40px"> </td>
                        <td>
                            <v-text-field  color="red darken-3"  type="password" single-line  />
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formPw2.png" width="140" style="margin-left:40px"> </td>
                        <td>
                            <v-text-field color="red darken-3" type="password" single-line  />
                        </td>
                    </tr>
                    <tr>
                    <td><img src="@/assets/form/formName.png" width="110" style="margin-left:50px"> </td>
                        <td>
                        <v-text-field color="red darken-3" outlined :value="userInfo.name" />
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formBirth.png" width="100" style="margin-left:50px"> </td>
                        <td>
                            <v-text-field color="red darken-3" outlined type="date" single-line :value="userInfo.birth" />
                        </td>
                    </tr>
                    <tr>
                        <td><img src="@/assets/form/formIntro.png" width="96" style="margin-left:48px"> </td>
                        <td>
                            <v-textarea color="red darken-3" outlined cols="40" rows="5" >
                            </v-textarea>
                        </td>
                    </tr>
                </table>
                <br/>
                <v-flex class="infoBtn">
                    <v-btn @click="isCorrect()" width="150" height="50" type="button" color="red darken-3" dark>Modify</v-btn>
                </v-flex>
                <br/>
             </form>
         </v-layout>
     </v-container>
</template>
<script>
export default {
    name: 'MemberInfo',
    props: {
        userInfo: {
            type: Object,
            required: true
        }
    }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');

td{
    padding-right: 35px;
}
.v-text-field {
    width:300px;
    font-family: 'Noto Sans KR', sans-serif;
}
.infoBtn {
    margin-left:35%;
}
</style>