<template>
    <div>
        <v-container style="max-width: 1000px; margin-top: 85px;">
        <v-flex>
            <div style="display: flex; justify-content: center;">

                <div style="border-radius: 70%; overflow: hidden;  margin-right: 45px;">
                    <v-img v-if="member.imageName" width="150px" height="150px" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                    <v-img v-else width="150px" height="150px" src="@/assets/profile.jpg"/>
                </div>

                <div style="width: 620px;  padding-left: 50px;">
                    <div style="display: flex;">
                        <div style="font-size: 28px;">{{member.memberId}}</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <router-link style="text-decoration: none;" :to="{
                            name: 'AccountsEditPage',
                            params: {memberNo: member.memberNo.toString()}}">
                            <v-btn v-if="member.memberNo==loginInfo.memberNo" style="margin: 4px 0px 0px 10px;" color="white">프로필 편집</v-btn>
                        </router-link>
                    </div>
                    <br/>
                    <div style="padding-bottom: 20px;">
                        게시물 <b>{{myBoards.length}}</b>
                    </div>
                    <b>{{member.memberName}}</b>
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
      },
        myBoards: {
            type: Array
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },

}
</script>

