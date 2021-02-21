package 大作业;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Control {

	LinkedList<Customer> list;
	LinkedList<Customer> sortList;
	LinkedList<Customer> list_OnFloor;
	LinkedList<Customer> waitList;
	Lift lift;
	SpecialQueen[] floor = new SpecialQueen[105];
	UI pane;

	public Control(UI pane) {
		list = new LinkedList<>();
		sortList = new LinkedList<>();
		list_OnFloor = new LinkedList<>();
		waitList = new LinkedList<>();
		lift = new Lift(1, false, 2, true);
		this.pane = pane;
		setListOnFloor();
	}

	public void setListOnFloor() {
		for (int i = 1; i < 105; i++) {

			floor[i] = new SpecialQueen();

		}
	}
	public void  getInfo() throws IOException, ClassNotFoundException{
		CustomerInfo info=new CustomerInfo();
		info.writeInfo();
		list=info.readInfo();
		sortList=info.readInfo();
	}

	public void sortForTime() {

		Collections.sort(sortList, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {

				if (o1.ComingTime > o2.ComingTime) {
					return 1;
				} else if (o1.ComingTime < o2.ComingTime) {
					return -1;
				}

				return 0;
			}
		});
	}

	public void run() {
		lift.setFloor(1);
		int Runtime = 0;
		int Roundtime = 0;
		while (!sortList.isEmpty() || !lift.List_OnLift.isEmpty() || !list_OnFloor.isEmpty()) {
			if (!sortList.isEmpty()) {

				if (sortList.get(0).ComingTime == Runtime) {
					list_OnFloor.add(sortList.get(0));
					waitList.add(sortList.get(0));
					sortList.remove(0);
				}
			}
			if (!list_OnFloor.isEmpty() || !lift.List_OnLift.isEmpty()) {
				if (lift.List_OnLift.isEmpty()) {
					lift.UpOrDown = lift.floor < list_OnFloor.getFirst().SF;
					if (lift.floor == list_OnFloor.getFirst().SF) {
						lift.UpOrDown = list_OnFloor.getFirst().getSF()<list_OnFloor.getFirst().getDF();
					}
				} else {
					lift.UpOrDown = lift.List_OnLift.getFirst().getSF()<lift.List_OnLift.getFirst().getDF();
				}
				if (!waitList.isEmpty()) {
					if (list_OnFloor.getFirst().getSF()<list_OnFloor.getFirst().getDF()) {
						if (list_OnFloor.getFirst().getSF()<list_OnFloor.getFirst().getDF()) {
							floor[waitList.getFirst().SF].Old_up
									.add(waitList.get(0));
						} else {
							floor[waitList.getFirst().SF].Young_up
									.add(waitList.get(0));
						}
					} else {
						if (waitList.getFirst().getAge()>60) {
							floor[waitList.getFirst().SF].Old_up
									.add(waitList.get(0));
						} else {
							floor[waitList.getFirst().SF].Young_down
									.add(waitList.get(0));
						}
					}
					waitList.remove(0);
				}
				if (lift.isFloor) {
					if (!lift.List_OnLift.isEmpty()) {
						Customer p = new Customer();
						if (lift.List_OnLift.getFirst().DF == lift.floor) {

							if (!lift.isOpen) {
								pane.openTheDoor();
								lift.isOpen = true;
							}

							p = lift.List_OnLift.poll();
							lift.peopleNum--;
							Runtime++;
							p.LeavingTime = Runtime;
							System.out.println(p.getID()+"\t"+p.getAge()+"\t"+p.getComingTime()+"\t\t"+p.getSF()+"\t"+p.getDF()+"\t"+p.getLeavingTime());
							continue;
						}
					}
					if (lift.peopleNum < lift.MAX) {
						if (lift.UpOrDown) {
							if (!floor[lift.getFloor()].getOld_up().isEmpty()) {

								if (!lift.isOpen) {
									pane.openTheDoor();
									lift.isOpen = true;
								}

								lift.List_OnLift.add(floor[lift.getFloor()].Old_up.getFirst());
								list_OnFloor.remove(floor[lift.getFloor()].Old_up.getFirst());
								floor[lift.getFloor()].Old_up.poll();
								lift.sort();
								Runtime++;
								continue;
							} else if (!floor[lift.getFloor()].getYoung_up().isEmpty()) {

								if (!lift.isOpen) {
									pane.openTheDoor();
									lift.isOpen = true;
								}

								lift.List_OnLift.add(floor[lift.getFloor()].Young_up.getFirst());
								list_OnFloor.remove(floor[lift.getFloor()].Young_up.getFirst());
								floor[lift.getFloor()].Young_up.poll();
								Runtime++;
								lift.sort();
								continue;
							} else {
								if (lift.isOpen) {
									pane.closeTheDoor();
									lift.isOpen = false;
								}
								lift.isFloor = false;
							}
						} else {
							if (!floor[lift.getFloor()].getOld_down().isEmpty()) {

								if (!lift.isOpen) {
									pane.openTheDoor();
									lift.isOpen = true;
								}

								lift.List_OnLift.add(floor[lift.getFloor()].Old_down.getFirst());
								list_OnFloor.remove(floor[lift.getFloor()].Old_down.getFirst());
								floor[lift.getFloor()].Old_down.poll();
								Runtime++;
								lift.sort();
								continue;
							} else if (!floor[lift.getFloor()].getYoung_down().isEmpty()) {

								if (!lift.isOpen) {
									pane.openTheDoor();
									lift.isOpen = true;
								}

								lift.List_OnLift.add(floor[lift.getFloor()].Young_down.getFirst());
								list_OnFloor.remove(floor[lift.getFloor()].Young_down.getFirst());
								floor[lift.getFloor()].Young_down.poll();
								Runtime++;
								lift.sort();
								continue;
							} else {

								if (lift.isOpen) {
									pane.closeTheDoor();
									lift.isOpen = false;
								}

								lift.isFloor = false;
							}
						}
					} else {

						if (lift.isOpen) {
							pane.closeTheDoor();
							lift.isOpen = false;
						}

						lift.isFloor = false;
					}
				}

				Roundtime++;
				if (Roundtime == 10) {

					if (lift.UpOrDown) {
						pane.up();
					} else {
}

					if (lift.UpOrDown) {
						lift.floor++;
					} else {
						lift.floor--;
					}
					lift.isFloor = true;
					Roundtime = 0;
				}

			}
			Runtime++;

		}
		if (lift.isOpen) {
			pane.closeTheDoor();
			lift.isOpen = false;
		}
	}

	public void sortFloor() {
		Collections.sort(list_OnFloor, new Comparator<Customer>() {

			/**
			 * 上升就上升到顶部 下降就下降到底部
			 */
			@Override
			public int compare(Customer o1, Customer o2) {
				if (lift.UpOrDown) {
					if (o1.SF > o2.SF) {
						return 1;
					} else if (o1.SF < o2.SF) {
						return -1;
					}
				} else {
					if (o1.SF > o2.SF) {
						return 1;
					} else if (o1.SF < o2.SF) {
						return -1;
					}
				}

				return 0;
			}
		});
	}

}
