<template>
    <div>
        <v-container style="max-width: 1000px; margin-top: 20px;">
        <v-flex>
            <div style="display: flex; justify-content: center;">
                <div style="width: 300px; padding-left: 75px;">
                    <v-img v-if="member.imageName" width="150" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                    <v-img v-else width="150" src="@/assets/logo.png"/>
                </div>
                <div style="width: 620px; margin-left: 20px;">
                    <div style="display: flex;">
                        <h1>{{member.memberId}}</h1> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <router-link style="text-decoration: none;" :to="{
                            name: 'AccountsEditPage',
                            params: {memberNo: member.memberNo.toString()}}">
                            <v-btn style="margin-top: 5px;" color="white">프로필 편집</v-btn>
                        </router-link>
                    </div>
                    <br/>
                    <div style="font-weight: bold">
                        {{member.memberName}}
                    </div>
                    {{member.memberWeb}} 
                    <br/>
                    {{member.memberIntro}} 
                </div>
            </div>
            <br/>
            <br/>
            
        </v-flex>
        </v-container>
    </div>    
</template>

<script>


export default {
    name: 'MyProfile',
    props: {
      member: {
        type: Object,
        require:true
      }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },

}
</script>

