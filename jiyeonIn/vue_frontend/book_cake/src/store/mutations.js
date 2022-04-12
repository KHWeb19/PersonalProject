import {
    FETCH_CAKE_LISTS,
    FETCH_BOOKING_LISTS,
    FETCH_BOOKING_BOARD,
    FETCH_BOARD_COMMENTS
}from './mutation-types'

export default {
    [FETCH_CAKE_LISTS] (state, cakeLists) {
        state.cakeLists = cakeLists
    },
    [FETCH_BOOKING_LISTS] (state, bookingLists) {
        state.bookingLists = bookingLists
    },
    [FETCH_BOOKING_BOARD] (state, BookingBoard) {
        state.BookingBoard = BookingBoard
    },
    [FETCH_BOARD_COMMENTS] (state, boardComments) {
        state.boardComments = boardComments
    }
}