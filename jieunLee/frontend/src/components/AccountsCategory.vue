<template>
    <div>
        <v-container style="width: 250px; margin-top: 20px; padding-right: 0px">
            <v-flex>
                <v-card style="height: 600px">
                    <router-link style="text-decoration: none;" :to="{
                        name: 'AccountsEditPage',
                        params: {memberNo: loginInfo.memberNo.toString()}}">
                        <v-btn>프로필 편집</v-btn>
                    </router-link>
                    <br/>
                    <router-link style="text-decoration: none;" :to="{
                        name: 'PasswordEditPage',
                        }">
                        <v-btn>비밀번호 변경</v-btn>
                    </router-link>
                    <br/>
                    <router-link style="text-decoration: none;" :to="{
                        name: 'PasswordEditPage',
                        }">
                        <v-btn>회원탈퇴</v-btn>
                    </router-link>
                </v-card>
            </v-flex>
        </v-container>
    </div>
</template>

<script>

export default {
    data: () => ({
    loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
    }),
  }
</script>