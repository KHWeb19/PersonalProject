<template>
    <div class="myPageForm">
        <h4>MY 페이지</h4>
        <br><br>
        <div class="left_menu">
            <ul>
                <li>
                    <router-link :to="{ name: 'MyPage'}">
                        <strong> 나의 정보 수정 </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageBooking'}">
                        <strong> 예약 내역 확인  </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageReview'}">
                        <strong> 후기 내역 확인  </strong>
                    </router-link>
                </li>
            </ul>
        </div>

        
        <div class="right_content">
            <h4>예약 내역 확인</h4>
            <br>
            

            
        </div>
        
    </div>
</template>

<script>
    export default {
        name: 'MyPageBookingForm',
        props: {
        },
        data(){
            return {
            }
        },
    }
</script>

<style scoped>
.myPageForm{
    display: grid;
    grid-template-columns: 200px 600px;
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