<template>
    <div>
        <v-container style="max-width: 1000px; margin-top: 85px;">
        <v-flex>
            <div style="display: flex; justify-content: center;">
                <div style="width: 300px; padding-left: 75px;">
                    <v-img v-if="member.imageName" width="150" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                    <v-img v-else width="150" src="@/assets/logo.png"/>
                </div>
                <div style="width: 620px; margin-left: 20px;">
                    <div style="display: flex;">
                        <div style="font-size: 28px">{{member.memberId}}</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <router-link style="text-decoration: none;" :to="{
                            name: 'AccountsEditPage',
                            params: {memberNo: member.memberNo.toString()}}">
                            <v-btn style="margin-top: 5px;" color="white">프로필 편집</v-btn>
                        </router-link>
                    </div>
                    <br/>
                    {{member.memberName}}
                    <div v-if="member.memberWeb">
                        {{member.memberWeb}} 
                        <br/>
                        {{member.memberIntro}} 
                    </div>
                    <div v-else>
                        {{member.memberIntro}} 
                    </div>
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

