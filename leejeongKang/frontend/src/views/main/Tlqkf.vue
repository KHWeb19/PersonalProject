<template>
    <div>
        <h1>점수를 입력하세요</h1><br>
        <div id="content1">
            자바: <input type="number">
            SQL: <input type="number">
        </div><br><br>
        <div id="btn">
            <v-btn type="submit" @click="calculation">계산하기</v-btn>
        </div><br><br>
        <div id="content2">
            총점: <input type="number">
            평균: <input type="number">
        </div>
    </div>
</template>

<style scoped>
h1 { font-size: 60px;  text-align: center;}
#btn { text-align: center;}
#content1 {  text-align: center; }
#content2 {  text-align: center; }
input { border: 1px solid #bbb; }
</style>
