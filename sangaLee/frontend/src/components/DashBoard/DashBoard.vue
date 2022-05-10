<template>
    <div class="dashboard">

        <div class="section1">
        <h2>Success follows doing what you want to do.<br>
There is no other way to be successful.</h2>
        <button class="start">START</button>
        </div>

        <div class="backgrond">
            <img src="../../assets/img/boy.png">
        </div>

        <div class="btns">

        <!-- 캘린더 -->
            <router-link :to="{name: 'CalendarPage'}">
                <button class="cdbtn">Calendar</button>
            </router-link>
        
        <!-- TodoList -->
            <router-link :to="{name: 'Todo'}">
                <button v-on:click="handleClick" class="todobtn">TodoList</button>
           </router-link>
        </div>

    </div>

</template>

<script>
export default {
    methods: {
        handleClick() {
            
        }
    }
}
</script>

<style scoped>
.dashboard {
    position: relative;
}
.section1 {
    margin-left: 15px;
}
h2 {
    margin-top: 100px;
    margin-left: 80px;
    font-size: 30px;
    color: #6768ab;
}
.start {
    width: 120px;
    height: 45px;
    margin-top: 30px;
    margin-left: 80px;
    background-color: #6768ab;
    color: #fff;
    border-radius: 50em;
}
img {
    max-width: 800px;
    margin-left: 450px;
    margin-top: -240px;
}
.btns {
    margin-left: 80px;
    margin-top: 15px;
    font-size: 50px;
}
.cdbtn {
    width: 500px;
    height: 500px;
    background-color: #cccae3;
    color: #6768ab;
    border-radius: 50px;
    display:inline-block;
}
.todobtn {
    background-color: #cccae3;
    color: #6768ab;
    width: 500px;
    height: 500px;
    border-radius: 50px;
    margin-left: 35px;
    display:inline-block;
}

</style>