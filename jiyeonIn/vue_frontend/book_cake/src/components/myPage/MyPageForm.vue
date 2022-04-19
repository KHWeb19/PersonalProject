<template>
    <div class="myPageForm">
        <h4>MY 페이지</h4>
        <br><br>
        <div class="left_menu">
            <ul>
                <li>
                    <router-link :to="{ name: 'MyPage',
                                    params: { id: this.id }}">
                        <strong> 나의 정보 수정 </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageBooking',
                                    params: { id: this.id }}">
                        <strong> 예약 내역 확인  </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageReview',
                                    params: { id: this.id }}">
                        <strong> 후기 내역 확인  </strong>
                    </router-link>
                </li>
            </ul>
        </div>

        <form @submit.prevent="onSubmit">
            <div class="right_content">
                <h4>나의 정보 수정</h4>
                <br>
                <v-container class="inputYourInfo">
                    <v-text-field flat v-model="id" type="text" disabled dense required ></v-text-field>
                    <v-text-field flat v-model="name" type="text"  dense clearable required placeholder="이름 변경하기" ></v-text-field>
                    <br>
                    <v-text-field flat v-model="pw" type="password"  dense  placeholder="비밀번호 변경하기" :rules="rules_pw" ></v-text-field>
                    <v-text-field flat v-model="pw1" type="password"  dense  placeholder="비밀번호 변경 확인" :rules="rules_pw1"></v-text-field>
                    <br>
                    <v-btn color="black" text type="submit" width="260"  style="text-align: center; margin: 0 0 0 18%;">
                    <v-icon>mdi-login</v-icon>정보 수정하기</v-btn>
                </v-container>

                
            </div>
        </form>
        
    </div>
</template>

<script>
    export default {
        name: 'MyPageForm',
        props: {
            memberInfo: {
                type: Object,
                required: true
            }
        },
        data(){
            return {
                rules_pw: [
                    v => v.length >= 6 || '비밀번호를 6자리 이상 입력해주세요'
                ],
                rules_pw1: [
                    v => v === this.pw || '비밀번호가 일치하지 않습니다'
                ],
                name:this.memberInfo.name,
                pw:'',
                pw1:'',
                id: this.memberInfo.id,
                userName:'',
                password:'',
                auth:'',
            }
        },
        methods: {
            onSubmit() {
                this.userName = this.name
                this.auth = this.memberInfo.auth

                if(this.pw.length > 0) {
                    this.password = this.pw
                    const { userName, password, auth } = this
                    this.$emit('submit', { userName, password, auth })

                }else{
                    this.password = 'no'
                    const { userName, password, auth } = this
                    this.$emit('submit', { userName, password, auth })
                }
                
            }
        }
    }
</script>

<style scoped>
.myPageForm{
    display: grid;
    grid-template-columns: 250px 600px;
}
.left_menu {
    width: 200px;
    height: 500px;
    border-right-width:3px; border-right-color:rgb(226, 154, 154);; border-right-style:dotted;
    padding: 3%;
}

.right_content {
    margin: 5% 0 0 25%;
}


ul a {
    color: inherit;
}

ul{
    list-style: none;
    margin: 20% 0 0 0;
}

a {
    text-decoration: none;
}
</style>