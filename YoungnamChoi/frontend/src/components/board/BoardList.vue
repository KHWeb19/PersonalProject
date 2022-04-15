<template>
  <v-container>
    <v-card elevation="10" outlined width="100%" class="mx-auto">
      <v-card-title> Board </v-card-title>
      <v-card-text>
        <v-row>
          <v-col cols="12" md="8">
            <v-text-field
              v-model="schVal"
              label="검색어"
              single-line
              @keypress.enter.prevent="getBoardList"
            ></v-text-field>
          </v-col>
          <v-col align-self="center">
            <Button
              @click="getBoardList"
              color="blue-grey darken-1"
              rounded
              small
              block
              iconName="mdi-magnify"
              btnName="Search"
              >검색</Button
            >
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-data-table
              class="elevation-1"
              @click:row="onClickRow"
              :headers="headers"
              :items="document"
              :options.sync="options"
              :server-items-length="totalCount"
              :footer-props="footerOptions"
              :loading="loading"
            >
              <template slot="items" slot-scope="props">
                <td>{{ props.item.docNo }}</td>
                <td>{{ props.item.title }}</td>
                <td>{{ props.item.writer }}</td>
                <td>{{ props.item.regDttm }}</td>
                <td>{{ props.item.view }}</td>
                <td>{{ props.item.reply }}</td>
              </template>
            </v-data-table>
          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
    <v-fab-transition>
      <Button
        @click="movePage('/write')"
        color="blue-grey darken-1"
        fab
        left
        bottom
        fixed
        iconName="mdi-pencil"
        >글쓰기</Button
      >
    </v-fab-transition>
  </v-container>
</template>

<script>
export default {
  name: "BoardList",
  props: {
    Boards: {
      type: Array,
    },
  },
};
</script>
