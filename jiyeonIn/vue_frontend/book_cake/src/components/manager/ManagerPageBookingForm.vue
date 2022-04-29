<template>
    <div class="myPageForm">
        <h4>MY 페이지</h4>
        <br><br>
        <div class="left_menu">
            <ul>
                <li>
                    <router-link :to="{ name: 'ManagerPageMember'}">
                        <strong> 회원 정보 확인 </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'ManagerPageBooking'}">
                        <strong> 예약 정보 확인  </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'ManagerPageCake'}">
                        <strong> 케이크 정보 확인 </strong>
                    </router-link>
                </li>
            </ul>
        </div>
        
    </div>
</template>

<script>
    export default {
        
    }
</script>

<style scoped>
.myPageForm{
    display: grid;
    grid-template-columns: 90px 1000px;
}
.left_menu {
    width: 200px;
    border-right-width:3px; border-right-color:rgb(226, 154, 154);; border-right-style:dotted;
    padding: 3%;
}

.right_content {
    margin: 5% 0 0 20%;
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